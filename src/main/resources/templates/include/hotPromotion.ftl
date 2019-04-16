[@promotion_list productCategoryId=productCategory.id hasEnded=false count=3 ]
	[#assign hotPromotions = promotions /]
[/@promotion_list]
[#if hotPromotions?has_content ]
	<div class="hotPromotion">
		<dl>
			<dt>热销促销</dt>
			[#list hotPromotions as promotion ]
				<dd>
					<a href="${ctx}/promotion/${promotion.id}" title="${promotion.title}">
						<img src="${promotion. image}" alt="${promotion.title}" />
					</a>
				</dd>
			[/#list]
		</dl>
	</div>
[/#if]