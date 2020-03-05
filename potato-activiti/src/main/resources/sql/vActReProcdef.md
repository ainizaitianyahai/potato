sample
===
* 注释

	select #use("cols")# from v_act_re_procdef  where  #use("condition")#

cols
===
	ID_,REV_,CATEGORY_,NAME_,KEY_,VERSION_,DEPLOYMENT_ID_,RESOURCE_NAME_,DGRM_RESOURCE_NAME_,DESCRIPTION_,HAS_START_FORM_KEY_,HAS_GRAPHICAL_NOTATION_,SUSPENSION_STATE_,TENANT_ID_,ENGINE_VERSION_

updateSample
===
	
	ID_=#id#,REV_=#rev#,CATEGORY_=#category#,NAME_=#name#,KEY_=#key#,VERSION_=#version#,DEPLOYMENT_ID_=#deploymentId#,RESOURCE_NAME_=#resourceName#,DGRM_RESOURCE_NAME_=#dgrmResourceName#,DESCRIPTION_=#description#,HAS_START_FORM_KEY_=#hasStartFormKey#,HAS_GRAPHICAL_NOTATION_=#hasGraphicalNotation#,SUSPENSION_STATE_=#suspensionState#,TENANT_ID_=#tenantId#,ENGINE_VERSION_=#engineVersion#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and ID_=#id#
	@}
	@if(!isEmpty(rev)){
	 and REV_=#rev#
	@}
	@if(!isEmpty(category)){
	 and CATEGORY_=#category#
	@}
	@if(!isEmpty(name)){
	 and NAME_=#name#
	@}
	@if(!isEmpty(key)){
	 and KEY_=#key#
	@}
	@if(!isEmpty(version)){
	 and VERSION_=#version#
	@}
	@if(!isEmpty(deploymentId)){
	 and DEPLOYMENT_ID_=#deploymentId#
	@}
	@if(!isEmpty(resourceName)){
	 and RESOURCE_NAME_=#resourceName#
	@}
	@if(!isEmpty(dgrmResourceName)){
	 and DGRM_RESOURCE_NAME_=#dgrmResourceName#
	@}
	@if(!isEmpty(description)){
	 and DESCRIPTION_=#description#
	@}
	@if(!isEmpty(hasStartFormKey)){
	 and HAS_START_FORM_KEY_=#hasStartFormKey#
	@}
	@if(!isEmpty(hasGraphicalNotation)){
	 and HAS_GRAPHICAL_NOTATION_=#hasGraphicalNotation#
	@}
	@if(!isEmpty(suspensionState)){
	 and SUSPENSION_STATE_=#suspensionState#
	@}
	@if(!isEmpty(tenantId)){
	 and TENANT_ID_=#tenantId#
	@}
	@if(!isEmpty(engineVersion)){
	 and ENGINE_VERSION_=#engineVersion#
	@}
	
	