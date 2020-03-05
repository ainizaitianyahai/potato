sample
===
* 注释

	select #use("cols")# from s_task_record  where  #use("condition")#

cols
===
	id,task_id,creator,create_time,will_finish_time,priority,branch,state,influence,modifier_note,verify_note,r_analyse_note,r_design_note,r_realize_note,t_dispose_note,type
*,creator_id,r_design_id,r_realize_id,t_dispose_id

updateSample
===
	
	id=#id#,task_id=#taskId#,creator=#creator#,create_time=#createTime#,will_finish_time=#willFinishTime#,priority=#priority#,branch=#branch#,state=#state#,influence=#influence#,modifier_note=#modifierNote#,verify_note=#verifyNote#,r_analyse_note=#rAnalyseNote#,r_design_note=#rDesignNote#,r_realize_note=#rRealizeNote#,t_dispose_note=#tDisposeNote#,type=#type#,creator_id=#creatorId#
*	,r_design_id=#rDesignId#,r_realize_id=#rRealizeId#,t_dispose_id=#tDisposeId#
	

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(taskId)){
	 and task_id=#taskId#
	@}
	@if(!isEmpty(creator)){
	 and creator=#creator#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	@if(!isEmpty(willFinishTime)){
	 and will_finish_time=#willFinishTime#
	@}
	@if(!isEmpty(priority)){
	 and priority=#priority#
	@}
	@if(!isEmpty(branch)){
	 and branch=#branch#
	@}
	@if(!isEmpty(state)){
	 and state=#state#
	@}
	@if(!isEmpty(influence)){
	 and influence=#influence#
	@}
	@if(!isEmpty(modifierNote)){
	 and modifier_note=#modifierNote#
	@}
	@if(!isEmpty(verifyNote)){
	 and verify_note=#verifyNote#
	@}
	@if(!isEmpty(rAnalyseNote)){
	 and r_analyse_note=#rAnalyseNote#
	@}
	@if(!isEmpty(rDesignNote)){
	 and r_design_note=#rDesignNote#
	@}
	@if(!isEmpty(rRealizeNote)){
	 and r_realize_note=#rRealizeNote#
	@}
	@if(!isEmpty(tDisposeNote)){
	 and t_dispose_note=#tDisposeNote#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
*	@if(!isEmpty(creatorId)){
*	 and creator_id=#creatorId#
*	@}
*	@if(!isEmpty(rDesignId)){
*	 and r_design_id=#rDesignId#
*	@}
*	@if(!isEmpty(rRealizeId)){
*	 and r_realize_id=#rRealizeId#
*	@}
*	@if(!isEmpty(tDisposeId)){
*	 and t_dispose_id=#tDisposeId#
*	@}
*	