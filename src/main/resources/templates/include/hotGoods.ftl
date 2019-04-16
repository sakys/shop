[@goods_list productCategoryId=productCategory.id tagId=3 count=3 ]
	[#assign hotGoods = goodsList /]
[/@goods_list]
[#if hotGoods?has_content ]
	<div class="hotGoods">
		<dl>
			<dt>热销商品</dt>
			[#list goodsList as goods ]
				<dd>
					<a href="${ctx}/goods/content/${goods.id}">
						<img src="${goods.image}" alt="${goods.name}" />
						<span title="${goods.name}">${goods.name}</span>
					</a>
					<strong>
						￥${goods.price}
							<del>￥${goods.marketPrice}</del>
					</strong>
				</dd>
			[/#list]
		</dl>
	</div>
[/#if]