<!DOCTYPE html >
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/goods.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.lazyload.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $headerCart = $("#headerCart");
	var $compareBar = $("#compareBar");
	var $compareForm = $("#compareBar form");
	var $compareSubmit = $("#compareBar a.submit");
	var $clearCompare = $("#compareBar a.clear");
	var $goodsForm = $("#goodsForm");
	var $orderType = $("#orderType");
	var $pageNumber = $("#pageNumber");
	var $pageSize = $("#pageSize");
	var $gridType = $("#gridType");
	var $listType = $("#listType");
	var $size = $("#layout a.size");
	var $previousPage = $("#previousPage");
	var $nextPage = $("#nextPage");
	var $sort = $("#sort a, #sort li");
	var $orderMenu = $("#orderMenu");
	var $startPrice = $("#startPrice");
	var $endPrice = $("#endPrice");
	var $result = $("#result");
	var $productImage = $("#result img");
	var $addCart = $("#result a.addCart");
	var $exchange = $("#result a.exchange");
	var $addFavorite = $("#result a.addFavorite");
	var $addCompare = $("#result a.addCompare");
	
	var layoutType = getCookie("layoutType");
	if (layoutType == "listType") {
		$listType.addClass("currentList");
		$result.removeClass("grid").addClass("list");
	} else {
		$gridType.addClass("currentGrid");
		$result.removeClass("list").addClass("grid");
	}
	
	$gridType.click(function() {
		var $this = $(this);
		if (!$this.hasClass("currentGrid")) {
			$this.addClass("currentGrid");
			$listType.removeClass("currentList");
			$result.removeClass("list").addClass("grid");
			addCookie("layoutType", "gridType");
		}
		return false;
	});
	
	$listType.click(function() {
		var $this = $(this);
		if (!$this.hasClass("currentList")) {
			$this.addClass("currentList");
			$gridType.removeClass("currentGrid");
			$result.removeClass("grid").addClass("list");
			addCookie("layoutType", "listType");
		}
		return false;
	});
	
	$size.click(function() {
		var $this = $(this);
		$pageNumber.val(1);
		var pageSize = $this.attr("pageSize");
		$pageSize.val(pageSize);
		$goodsForm.submit();
		return false;
	});
	
	[#--$previousPage.click(function() {--]
		[#--$pageNumber.val(${resultList.pageInfo.page - 1});--]
		[#--$goodsForm.submit();--]
		[#--return false;--]
	[#--});--]
	[#----]
	[#--$nextPage.click(function() {--]
		[#--$pageNumber.val(${resultList.pageInfo.page + 1});--]
		[#--$goodsForm.submit();--]
		[#--return false;--]
	[#--});--]
	
	$orderMenu.hover(
		function() {
			$(this).children("ul").show();
		}, function() {
			$(this).children("ul").hide();
		}
	);
	
	$sort.click(function() {
		var $this = $(this);
		if ($this.hasClass("current")) {
			$orderType.val("");
		} else {
			$orderType.val($this.attr("orderType"));
		}
		$pageNumber.val(1);
		$goodsForm.submit();
		return false;
	});
	
	$startPrice.add($endPrice).focus(function() {
		$(this).siblings("button").show();
	});
	
	$startPrice.add($endPrice).keypress(function(event) {
		return (event.which >= 48 && event.which <= 57) || (event.which == 46 && $(this).val().indexOf(".") < 0) || event.which == 8 || event.which == 13;
	});
	
	$goodsForm.submit(function() {
		if ($orderType.val() == "" || $orderType.val() == "topDesc") {
			$orderType.prop("disabled", true);
		}
		if ($pageNumber.val() == "" || $pageNumber.val() == "1") {
			$pageNumber.prop("disabled", true);
		}
		/*
		if ($pageSize.val() == "" || $pageSize.val() == "20") {
			$pageSize.prop("disabled", true);
		}*/
		if ($startPrice.val() == "" || !/^\d+(\.\d+)?$/.test($startPrice.val())) {
			$startPrice.prop("disabled", true);
		}
		if ($endPrice.val() == "" || !/^\d+(\.\d+)?$/.test($endPrice.val())) {
			$endPrice.prop("disabled", true);
		}
		if ($goodsForm.serializeArray().length < 1) {
			location.href = location.pathname;
			return false;
		}
	});
	
	$productImage.lazyload({
		threshold: 100,
		effect: "fadeIn"
	});
	
	// 加入购物车
	$addCart.click(function() {
		var $this = $(this);
		var productId = $this.attr("productId");
		$.ajax({
			url: "${ctx}/cart/add",
			type: "POST",
			data: {goodsId: productId, quantity: 1},
			dataType: "json",
			cache: false,
			success: function(message) {
				if (message.resultCode == 1) {
					var $image = $this.closest("li").find("img");
					var cartOffset = $headerCart.offset();
					var imageOffset = $image.offset();
					$image.clone().css({
						width: 170,
						height: 170,
						position: "absolute",
						"z-index": 20,
						top: imageOffset.top,
						left: imageOffset.left,
						opacity: 0.8,
						border: "1px solid #dddddd",
						"background-color": "#eeeeee"
					}).appendTo("body").animate({
						width: 30,
						height: 30,
						top: cartOffset.top,
						left: cartOffset.left,
						opacity: 0.2
					}, 1000, function() {
						$(this).remove();
					});
					$.message('success', message.result);
					$headerCart.find('em').html(parseInt($headerCart.find('em').html()) + 1);
				} else {
					$.message('error', message.resultMessage);
				}
				
			}
		});
		return false;
	});
	
	// 积分兑换
	$exchange.click(function() {
		var productId = $(this).attr("productId");
		$.ajax({
			url: "/shopxx/order/check_exchange.jhtml",
			type: "GET",
			data: {productId: productId, quantity: 1},
			dataType: "json",
			cache: false,
			success: function(message) {
				if (message.type == "success") {
					location.href = "/shopxx/order/checkout.jhtml?type=exchange&productId=" + productId + "&quantity=1";
				} else {
					$.message(message);
				}
			}
		});
		return false;
	});
	
	// 添加商品收藏
	$addFavorite.click(function() {
		var goodsId = $(this).attr("goodsId");
		$.ajax({
			url: "/shopxx/member/favorite/add.jhtml",
			type: "POST",
			data: {goodsId: goodsId},
			dataType: "json",
			cache: false,
			success: function(message) {
				$.message(message);
			}
		});
		return false;
	});
	
	// 对比栏
	var compareGoods = getCookie("compareGoods");
	var compareGoodsIds = compareGoods != null ? compareGoods.split(",") : [];
	if (compareGoodsIds.length > 0) {
		$.ajax({
			url: "/shopxx/goods/compare_bar.jhtml",
			type: "GET",
			data: {goodsIds: compareGoodsIds},
			dataType: "json",
			cache: true,
			success: function(data) {
				$.each(data, function (i, item) {
					var thumbnail = item.thumbnail != null ? item.thumbnail : "/shopxx/upload/image/default_thumbnail.jpg";
					$compareBar.find("dt").after(
'<dd> <input type="hidden" name="goodsIds" value="' + item.id + '" \/> <a href="' + escapeHtml(item.url) + '" target="_blank"> <img src="' + escapeHtml(thumbnail) + '" \/> <span title="' + escapeHtml(item.name) + '">' + escapeHtml(abbreviate(item.name, 50)) + '<\/span> <\/a> <strong>' + currency(item.price, true) + '<del>' + currency(item.marketPrice, true) + '<\/del><\/strong> <a href="javascript:;" class="remove" goodsId="' + item.id + '">[删除]<\/a> <\/dd>'					);
				});
				$compareBar.fadeIn();
			}
		});
		
		$.each(compareGoodsIds, function(i, goodsId) { 
			$addCompare.filter("[goodsId='" + goodsId + "']").addClass("selected");
		});
	}
	
	// 移除对比
	$compareBar.on("click", "a.remove", function() {
		var $this = $(this);
		var goodsId = $this.attr("goodsId");
		$this.closest("dd").remove();
		for (var i = 0; i < compareGoodsIds.length; i ++) {
			if (compareGoodsIds[i] == goodsId) {
				compareGoodsIds.splice(i, 1);
				break;
			}
		}
		$addCompare.filter("[goodsId='" + goodsId + "']").removeClass("selected");
		if (compareGoodsIds.length == 0) {
			$compareBar.fadeOut();
			removeCookie("compareGoods");
		} else {
			addCookie("compareGoods", compareGoodsIds.join(","));
		}
		return false;
	});
	
	$compareSubmit.click(function() {
		if (compareGoodsIds.length < 2) {
			$.message("warn", "至少需要两个对比商品");
			return false;
		}
		
		$compareForm.submit();
		return false;
	});
	
	// 清除对比
	$clearCompare.click(function() {
		$addCompare.removeClass("selected");
		$compareBar.fadeOut().find("dd:not(.action)").remove();
		compareGoodsIds = [];
		removeCookie("compareGoods");
		return false;
	});
	
	// 添加对比
	$addCompare.click(function() {
		var $this = $(this);
		var goodsId = $this.attr("goodsId");
		if ($.inArray(goodsId, compareGoodsIds) >= 0) {
			return false;
		}
		if (compareGoodsIds.length >= 4) {
			$.message("warn", "最多只允许添加4个对比商品");
			return false;
		}
		$.ajax({
			url: "/shopxx/goods/add_compare.jhtml",
			type: "GET",
			data: {goodsId: goodsId},
			dataType: "json",
			cache: false,
			success: function(data) {
				if (data.message.type == "success") {
					$this.addClass("selected");
					var thumbnail = data.thumbnail != null ? data.thumbnail : "/shopxx/upload/image/default_thumbnail.jpg";
					$compareBar.show().find("dd.action").before(
'<dd> <input type="hidden" name="goodsIds" value="' + data.id + '" \/> <a href="' + escapeHtml(data.url) + '" target="_blank"> <img src="' + escapeHtml(thumbnail) + '" \/> <span title="' + escapeHtml(data.name) + '">' + escapeHtml(abbreviate(data.name, 50)) + '<\/span> <\/a> <strong>' + currency(data.price, true) + '<del>' + currency(data.marketPrice, true) + '<\/del><\/strong> <a href="javascript:;" class="remove" goodsId="' + data.id + '">[删除]<\/a> <\/dd>'					);
					compareGoodsIds.unshift(goodsId);
					addCookie("compareGoods", compareGoodsIds.join(","));
				} else {
					$.message(data.message);
				}
			}
		});
		return false;
	});
	
	$.pageSkip = function(pageNumber) {
		$pageNumber.val(pageNumber);
		$goodsForm.submit();
		return false;
	}
	
	var $brand = $("#filter a.brand");
	var $brandId = $("#brandId");
	$brand.each(function() {
		$(this).click(function() {
			var $this = $(this);
			if ($this.hasClass("current")) {
				$brandId.val("");
			} else {
				$brandId.val($this.attr("brandId"));
			}
			$pageNumber.val(1);
			$goodsForm.submit();
			return false;
		})
	});
	
	var $attribute = $("#filter a.attribute");
	console.log($attribute)
	$attribute.click(function() {
		var $this = $(this);
		if ($this.hasClass("current")) {
			$this.closest("dl").find("input").prop("disabled", true);
		} else {
			$this.closest("dl").find("input").prop("disabled", false).val($this.text());
		}
		$pageNumber.val(1);
		$goodsForm.submit();
		return false;
	});
});

</script>
</head>
<body>
<script type="text/javascript">
$().ready(function() {

	var $headerName = $("#headerName");
	var $headerLogin = $("#headerLogin");
	var $headerRegister = $("#headerRegister");
	var $headerLogout = $("#headerLogout");
	var $goodsSearchForm = $("#goodsSearchForm");
	var $keyword = $("#goodsSearchForm input");
	var defaultKeyword = "商品搜索";
	
	var username = getCookie("username");
	var nickname = getCookie("nickname");
	if ($.trim(nickname) != "") {
		$headerName.text(nickname).show();
		$headerLogout.show();
	} else if ($.trim(username) != "") {
		$headerName.text(username).show();
		$headerLogout.show();
	} else {
		$headerLogin.show();
		$headerRegister.show();
	}
	
	$keyword.focus(function() {
		if ($.trim($keyword.val()) == defaultKeyword) {
			$keyword.val("");
		}
	});
	
	$keyword.blur(function() {
		if ($.trim($keyword.val()) == "") {
			$keyword.val(defaultKeyword);
		}
	});
	
	$goodsSearchForm.submit(function() {
		if ($.trim($keyword.val()) == "" || $keyword.val() == defaultKeyword) {
			return false;
		}
	});

});
</script>
	[#include "./include/header.ftl"]
	<div class="container goodsList">
		<div id="compareBar" class="compareBar">
			<form action="/shopxx/goods/compare.jhtml" method="get">
				<dl>
					<dt>对比栏</dt>
					<dd class="action">
						<a href="javascript:;" class="submit">对 比</a>
						<a href="javascript:;" class="clear">清 空</a>
					</dd>
				</dl>
			</form>
		</div>
		<div class="row">
			<div class="span2">
				[#include "./include/hotProductCategory.ftl"]
				[#include "./include/hotBrand.ftl"]
				[#include "./include/hotGoods.ftl"]
				[#include "./include/hotPromotion.ftl"]
			</div>
			<div class="span10">
				<div class="breadcrumb">
					<ul>
						<li>
							<a href="${ctx}/index">首页</a>
						</li>

						[@product_category_parent_list productCategoryId = productCategory.id]
							[#list productCategories as productCategory]
								<li><a href="${ctx}/goods/list/${productCategory.id}">${productCategory.name}</a></li>
							[/#list]
						[/@product_category_parent_list]
						<li>${productCategory.name}</li>
					</ul>
				</div>
				<form id="goodsForm" action="${ctx}/goods/list/${resultList.baseDto.productCategoryId}" method="get">
					<input type="hidden" id="keyword" name="keyword" value="${resultList.baseDto.keyword}" />
					<input type="hidden" id="orderType" name="sort" value="${resultList.baseDto.sort}" />
					<input type="hidden" id="pageNumber" name="page" value="${resultList.baseDto.page}" />
					<input type="hidden" id="pageSize" name="pageSize" value="${resultList.baseDto.pageSize}" />
					<input type="hidden" id="brandId" name="brandId" value="${resultList.baseDto.brandId}" />
					<div id="filter" class="filter">
						<div class="title">筛选商品</div>
						<div class="content">
							[@product_category_children_list productCategoryId=productCategory.id recursive=false count=10000 ]
								[#assign productCategoryVars = productCategories ]
							[/@product_category_children_list]
							[#if productCategoryVars?has_content ]
								<dl class="clearfix">
									<dt>分类:</dt>
									[#list productCategoryVars as productCategoriy ]
										<dd>
											<a href="${ctx}/goods/list/${productCategoriy.id}">${productCategoriy.name}</a>
										</dd>
									[/#list]
									<dd class="moreOption" title="更多">&nbsp;</dd>
								</dl>
							[/#if]

							[@brand_list productCategoryId=productCategory.id count=10000 ]
								[#assign brandVars = brands ]
							[/@brand_list]

							[#if brandVars?has_content ]
								<dl class="clearfix">
									<dt>品牌:</dt>
									[#list brands as brand ]
										<dd>
											<a href="javascript:;" class="brand [#if resultList.baseDto.brandId??&&resultList.baseDto.brandId=brand.id ] current[/#if]" brandId="${brand.id}">${brand.name}</a>
										</dd>
									[/#list]
									<dd class="moreOption" title="更多">&nbsp;</dd>
								</dl>
							[/#if]
						</div>
						<div class="content">
							[@attribute_list articleCategoryId = productCategory.id ]
								[#list attributes as attribute]
									<dl class="clearfix">
										<dt>
											<input type="hidden" name="attributeValue${attribute.id - 1}" disabled="disabled">
											<span title="${attribute.name}">${attribute.name}:</span>
										</dt>
										[#list attribute.optionsList as attr]
											<dd>
												<a href="javascript:;" class="attribute [#if (attribute.id - 1 == 0 && resultList.baseDto.attributeValue0 == attr) ||
													(attribute.id - 1 == 1 && resultList.baseDto.attributeValue1 == attr)  ||
													(attribute.id - 1 == 2 && resultList.baseDto.attributeValue2 == attr)  ||
													(attribute.id - 1 == 3 && resultList.baseDto.attributeValue3 == attr) ]
													current[/#if]">${attr}</a>
											</dd>
										[/#list]
										<dd class="moreOption" title="更多">&nbsp;</dd>
									</dl>
								[/#list]
							[/@attribute_list]
						</div>
						<div id="moreFilter" class="moreFilter">
								&nbsp;
						</div>
					</div>

					<div class="bar">
						<div id="layout" class="layout">
							<label>布局:</label>
							<a href="javascript:;" id="gridType" class="gridType">
								<span>&nbsp;</span>
							</a>
							<a href="javascript:;" id="listType" class="listType">
								<span>&nbsp;</span>
							</a>
							<label>数量:</label>
							<a href="javascript:;" class="size[#if resultList.pageInfo.limit==20 ] current[/#if]" pageSize="20">
								<span>20</span>
							</a>
							<a href="javascript:;" class="size[#if resultList.pageInfo.limit==40 ] current[/#if]" pageSize="40">
								<span>40</span>
							</a>
							<a href="javascript:;" class="size[#if resultList.pageInfo.limit==80 ] current[/#if]" pageSize="80">
								<span>80</span>
							</a>
							[#if resultList.pageInfo.totalCount > 0]
								<span class="page">
									<label>共${resultList.pageInfo.totalCount}个商品 ${resultList.pageInfo.page}/${resultList.pageInfo.totalPages}</label>
									[#if resultList.pageInfo.hasPrePage ]
										<a href="javascript:;" id="previousPage" class="previousPage">
											<span>上一页</span>
										</a>
									[/#if]
									[#if resultList.pageInfo.hasNextPage ]
										<a href="javascript:;" id="nextPage" class="nextPage">
											<span>下一页</span>
										</a>
									[/#if]
								</span>
							[/#if]
						</div>
						<div id="sort" class="sort">
							<div id="orderMenu" class="orderMenu">
								[#if currOrderType?? ]
									<span>${currOrderType.showOrderType}</span>
								[/#if]
								<ul>
									[#list orderTypes as orderType ]
										<li orderType="${orderType.sort}">${orderType.showOrderType}</li>
									[/#list]
								</ul>
							</div>
							<a href="javascript:;" class="asc [#if currOrderType.sort='price.asc' ]current[/#if] " orderType="price.asc">价格</a>
							<a href="javascript:;" class="desc [#if currOrderType.sort='sales.desc' ]current[/#if]" orderType="sales.desc">销量</a>
							<a href="javascript:;" class="desc [#if currOrderType.sort='score.desc' ]current[/#if]" orderType="score.desc">评分</a>
							<input type="text" id="startPrice" name="startPrice" class="startPrice" value="${resultList.baseDto.startPrice}" maxlength="16" title="价格过滤最低价格" onpaste="return false" />
							<label>-</label>
							<input type="text" id="endPrice" name="endPrice" class="endPrice" value="${resultList.baseDto.endPrice}" maxlength="16" title="价格过滤最高价格" onpaste="return false" />
							<button type="submit">确 定</button>
						</div>
					</div>
					<div id="result" class="result grid clearfix">
						[#if resultList.results?has_content]
							<ul>
								[#list resultList.results as goods ]
									<li>
										<a href="${ctx}/goods/content/${goods.id}">
											<img src="${ctx}/upload/image/blank.gif" data-original="${goods.image}" />
											<div>
												<span title="${goods.name}">${goods.name}</span>
												<em title="${goods.caption}">${goods.caption}</em>
											</div>
										</a>
										<strong>
												￥${goods.price}
													<del>￥${goods.marketPrice}</del>
										</strong>
										<div class="action">
											<a href="javascript:;" class="addCart" productId="${goods.id}">加入购物车</a>
											<a href="javascript:;" class="addFavorite" title="收藏" goodsId="${goods.id}">&nbsp;</a>
											<a href="javascript:;" class="addCompare" title="对比" goodsId="${goods.id}">&nbsp;</a>
										</div>
									</li>
								[/#list]
							</ul>
						[#else]
							<dl>
								<dt>对不起，没有找到符合您检索条件的商品</dt>
								<dd>1、请确认设置的检索条件是否正确</dd>
								<dd>2、可尝试修改检索条件，以获得更多的搜索结果</dd>
							</dl>
						[/#if]
					</div>

					[#if resultList.pageInfo.totalCount > 0 ]
						<div class="pagination">
							[#if resultList.pageInfo.firstPage ]
								<span class="firstPage">&nbsp;</span>
							[#else]
								<a href="javascript: $.pageSkip(1);" class="firstPage">&nbsp;</a>
							[/#if]

							[#if resultList.pageInfo.hasPrePage ]
								<a href="javascript: $.pageSkip(${resultList.pageInfo.page - 1});" class="previousPage">&nbsp;</a>
							[#else]
								<span class="previousPage">&nbsp;</span>
							[/#if]

							[#list resultList.pageInfo.slider as slider ]
								[#if slider == resultList.pageInfo.page ]
									<span class="currentPage">${slider}</span>
								[#else]
									<a href="javascript: $.pageSkip(${slider});">${slider}</a>
								[/#if]
							[/#list]

							[#if resultList.pageInfo.hasNextPage ]
								<a href="javascript: $.pageSkip(${resultList.pageInfo.page + 1});" class="nextPage">&nbsp;</a>
							[#else]
								<span class="nextPage">&nbsp;</span>
							[/#if]

							[#if resultList.pageInfo.lastPage ]
								<span class="lastPage">&nbsp;</span>
							[#else]
								<a href="javascript: $.pageSkip(${resultList.pageInfo.totalPages});" class="lastPage">&nbsp;</a>
							[/#if]
						</div>
					[/#if]
				</form>
			</div>
		</div>
	</div>
	[#include "include/footer.ftl" /]
</body>
</html>