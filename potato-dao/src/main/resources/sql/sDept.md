sample
===
* 注释

	select #use("cols")# from s_dept  where  #use("condition")#

cols
===
	id,parent_id,dept_name,status

updateSample
===
	
	id=#id#,parent_id=#parentId#,dept_name=#deptName#,status=#status#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(parentId)){
	 and parent_id=#parentId#
	@}
	@if(!isEmpty(deptName)){
	 and dept_name=#deptName#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	
	