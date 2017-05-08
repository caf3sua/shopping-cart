function toggleUpdateProduct(item) {
	console.log("toggleUpdateProduct");
	
	console.log(item.id);
	console.log(jQuery("#" + item.id).val());
	jQuery(this).closest(".admin-product-row-content").find(".admin-product-action-update").show();
}