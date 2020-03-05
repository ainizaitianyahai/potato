sample
===
* 注释

	select #use("cols")# from s_task  where  #use("condition")#

cols
===
	id,parent_id,code,explain,type,source,creator,create_time,will_finish_time,priority,branch,state,proposer,analyst,modifier,verify,closer,project,influence,modifier_note,verify_note,r_analyse,r_analyse_note,r_design,r_design_note,r_realize,r_realize_note,t_dispose,t_dispose_note,creator_id,analyst_id,modifier_id,verify_id,close_id,r_analyse_id,r_design_id,r_realize_id,t_dispose_id
	

updateSample
===
	
	id=#id#,parent_id=#parentId#,code=#code#,explain=#explain#,type=#type#,source=#source#,creator=#creator#,create_time=#createTime#,will_finish_time=#willFinishTime#,priority=#priority#,branch=#branch#,state=#state#,proposer=#proposer#,analyst=#analyst#,modifier=#modifier#,verify=#verify#,closer=#closer#,project=#project#,influence=#influence#,modifier_note=#modifierNote#,verify_note=#verifyNote#,r_analyse=#rAnalyse#,r_analyse_note=#rAnalyseNote#,r_design=#rDesign#,r_design_note=#rDesignNote#,r_realize=#rRealize#,r_realize_note=#rRealizeNote#,t_dispose=#tDispose#,t_dispose_note=#tDisposeNote#,creator_id=#creatorId#,analyst_id=#analystId#,modifier_id=#modifierId#,verify_id=#verifyId#,close_id=#closeId#,r_analyse_id=#rAnalyseId#,r_design_id=#rDesignId#,r_realize_id=#rRealizeId#,t_dispose_id=#tDisposeId#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(parentId)){
	 and parent_id=#parentId#
	@}
	@if(!isEmpty(code)){
	 and code=#code#
	@}
	@if(!isEmpty(explain)){
	 and explain=#explain#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
	@if(!isEmpty(source)){
	 and source=#source#
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
	@if(!isEmpty(proposer)){
	 and proposer=#proposer#
	@}
	@if(!isEmpty(analyst)){
	 and analyst=#analyst#
	@}
	@if(!isEmpty(modifier)){
	 and modifier=#modifier#
	@}
	@if(!isEmpty(verify)){
	 and verify=#verify#
	@}
	@if(!isEmpty(closer)){
	 and closer=#closer#
	@}
	@if(!isEmpty(project)){
	 and project=#project#
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
	@if(!isEmpty(rAnalyse)){
	 and r_analyse=#rAnalyse#
	@}
	@if(!isEmpty(rAnalyseNote)){
	 and r_analyse_note=#rAnalyseNote#
	@}
	@if(!isEmpty(rDesign)){
	 and r_design=#rDesign#
	@}
	@if(!isEmpty(rDesignNote)){
	 and r_design_note=#rDesignNote#
	@}
	@if(!isEmpty(rRealize)){
	 and r_realize=#rRealize#
	@}
	@if(!isEmpty(rRealizeNote)){
	 and r_realize_note=#rRealizeNote#
	@}
	@if(!isEmpty(tDispose)){
	 and t_dispose=#tDispose#
	@}
	@if(!isEmpty(tDisposeNote)){
	 and t_dispose_note=#tDisposeNote#
	@}
	
	@if(!isEmpty(creatorId)){
	 and creator_id=#creatorId#
	@}
	
	@if(!isEmpty(analystId)){
	 and analyst_id=#analystId#
	@}
	
	@if(!isEmpty(modifierId)){
	 and modifier_id=#modifierId#
	@}
	
	@if(!isEmpty(verifyId)){
	 and verify_id=#verifyId#
	@}
	
	@if(!isEmpty(closeId)){
	 and close_id=#closeId#
	@}
	
	@if(!isEmpty(rAnalyseId)){
	 and r_analyse_id=#rAnalyseId#
	@}
	
	@if(!isEmpty(rDesignId)){
	 and r_design_id=#rDesignId#
	@}
	
	@if(!isEmpty(rRealizeId)){
	 and r_realize_id=#rRealizeId#
	@}
	
	@if(!isEmpty(tDisposeId)){
	 and t_dispose_id=#tDisposeId#
	@}
	
searchCols
===
	task.id,task.parent_id,task.code,task.explain,task.type,task.source,task.creator,task.create_time,task.will_finish_time,task.priority,task.branch,task.state,task.proposer,task.analyst,task.modifier,task.verify,task.closer,task.project,task.influence,task.modifier_note,task.verify_note,task.r_analyse,task.r_analyse_note,task.r_design,task.r_design_note,task.r_realize,task.r_realize_note,task.t_dispose,task.t_dispose_note,task.creator_id,task.analyst_id,task.modifier_id,task.verify_id,task.close_id,task.r_analyse_id,task.r_design_id,task.r_realize_id,task.t_dispose_id
		
searchCondition
===

	1 = 1  
	@if(!isEmpty(task.id)){
	 and task.id=#task.id#
	@}
	@if(!isEmpty(task.parentId)){
	 and task.parent_id=#task.parentId#
	@}
	@if(!isEmpty(task.code)&&task.code!=''){
	 and task.code like  #'%'+task.code+'%'#
	@}
	@if(!isEmpty(task.explain)&&task.explain!=''){
	 and task.explain like  #'%'+task.explain+'%'#
	@}
	@if(!isEmpty(task.type)&&task.type!=''){
	 and task.type = #task.type#
	@}
	@if(!isEmpty(task.source)&&task.source!=''){
	 and task.source=#task.source#
	@}
	@if(!isEmpty(task.creator)){
	 and task.creator=#task.creator#
	@}
	@if(!isEmpty(createTime)){
	 and task.create_time=#createTime#
	@}
	@if(!isEmpty(task.willFinishTime)){
	 and task.will_finish_time=#task.willFinishTime#
	@}
	@if(!isEmpty(task.priority)){
	 and task.priority=#task.priority#
	@}
	@if(!isEmpty(task.branch)&&task.branch!=''){
	 and (task.branch = #task.branch# or task.branch like  #task.branch+',%'# or task.branch like  #'%,'+task.branch+',%'# or task.branch like  #'%,'+task.branch#)
	@}
	@if(!isEmpty(task.state)&&task.state!=''){
	 and task.state=#task.state#
	@}
	@if(!isEmpty(task.proposer)){
	 and task.proposer=#task.proposer#
	@}
	@if(!isEmpty(task.analyst)){
	 and task.analyst=#task.analyst#
	@}
	@if(!isEmpty(task.modifier)){
	 and task.modifier=#task.modifier#
	@}
	@if(!isEmpty(task.verify)){
	 and task.verify=#task.verify#
	@}
	@if(!isEmpty(task.closer)){
	 and task.closer=#task.closer#
	@}
	@if(!isEmpty(task.project)){
	 and task.project=#task.project#
	@}
	@if(!isEmpty(task.influence)){
	 and task.influence=#task.influence#
	@}
	@if(!isEmpty(task.modifierNote)){
	 and task.modifier_note=#task.modifierNote#
	@}
	@if(!isEmpty(task.verifyNote)){
	 and task.verify_note=#task.verifyNote#
	@}
	@if(!isEmpty(task.rAnalyse)){
	 and task.r_analyse=#task.rAnalyse#
	@}
	@if(!isEmpty(task.rAnalyseNote)){
	 and task.r_analyse_note=#task.rAnalyseNote#
	@}
	@if(!isEmpty(task.rDesign)){
	 and task.r_design=#task.rDesign#
	@}
	@if(!isEmpty(task.rDesignNote)){
	 and task.r_design_note=#task.rDesignNote#
	@}
	@if(!isEmpty(task.rRealize)){
	 and task.r_realize=#task.rRealize#
	@}
	@if(!isEmpty(task.rRealizeNote)){
	 and task.r_realize_note=#task.rRealizeNote#
	@}
	@if(!isEmpty(task.tDispose)){
	 and task.t_dispose=#task.tDispose#
	@}
	@if(!isEmpty(task.tDisposeNote)){
	 and task.t_dispose_note=#task.tDisposeNote#
	@}
	@if(!isEmpty(task.creatorId)){
	 and task.creator_id=#task.creatorId#
	@}
	
	@if(!isEmpty(task.analystId)){
	 and task.analyst_id=#task.analystId#
	@}
	
	@if(!isEmpty(task.modifierId)){
	 and task.modifier_id=#task.modifierId#
	@}
	
	@if(!isEmpty(task.verifyId)){
	 and task.verify_id=#task.verifyId#
	@}
	
	@if(!isEmpty(task.closeId)){
	 and task.close_id=#task.closeId#
	@}
	
	@if(!isEmpty(task.rAnalyseId)){
	 and task.r_analyse_id=#task.rAnalyseId#
	@}
	
	@if(!isEmpty(task.rDesignId)){
	 and task.r_design_id=#task.rDesignId#
	@}
	
	@if(!isEmpty(task.rRealizeId)){
	 and task.r_realize_id=#task.rRealizeId#
	@}
	
	@if(!isEmpty(task.tDisposeId)){
	 and task.t_dispose_id=#task.tDisposeId#
	@}
search
===
	select #use("searchCols")# from s_task task  where  
		#use("searchCondition")#	
		@if(!isEmpty(task.beginDate)){
		 and task.create_time>=#task.beginDate#
		@}
		@if(!isEmpty(task.endDate)){
		 and task.create_time<=#task.endDate#
		@}
		order by id asc
		
myTaskList
===
	select #use("searchCols")# from s_task task  where  
		#use("searchCondition")#	
		@if(!isEmpty(task.beginDate)){
		 and task.create_time>=#task.beginDate#
		@}
		@if(!isEmpty(task.endDate)){
		 and task.create_time<=#task.endDate#
		@}
		@if(!isEmpty(userName)){
		 	and (
		 	 	(task.analyst = #userName# && task.state=#stateArray[0]#) or	
		 		(task.modifier = #userName# && task.state=#stateArray[1]#) or
		 	 	(task.verify = #userName# && task.state=#stateArray[2]#) or
		 	 	(task.r_analyse = #userName# && task.state=#stateArray[3]#) or
		 	 	(task.r_design = #userName# && task.state=#stateArray[4]#) or
		 	 	(task.r_realize = #userName# && task.state=#stateArray[5]#) or
		 	 	(task.t_dispose = #userName# && task.state=#stateArray[6]#)
		 	)
		@}
		order by will_finish_time desc,priority asc