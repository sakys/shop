[@brand_list productCategoryId=productCategory.id type=1 count=6 ]
	[#assign hotBrands = brands /]
[/@brand_list]
[#if hotBrands?has_content ]
	<div class="hotBrand clearfix">
		<dl>
			<dt>热门品牌</dt>
			[#list brands as brand ]
				<dd [#if brand_index % 2 == 1 ]class="even"[/#if]>
					<a href="${ctx}/brand/content/${brand.id}" title="${brand.name}">
						<img src="${brand.logo}" alt="${brand.name}" />
						<span>${brand.name}</span>
					</a>
				</dd>
			[/#list]
		</dl>
	</div>
[/#if]