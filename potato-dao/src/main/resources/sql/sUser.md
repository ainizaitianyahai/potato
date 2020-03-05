sample
===
* 注释

	select #use("cols")# from s_user  where  #use("condition")#

cols
===
	id,user_id,user_name,dept_id,password,card_id,phone,birthdate,state

updateSample
===
	
	id=#id#,user_id=#userId#,user_name=#userName#,dept_id=#deptId#,password=#password#,card_id=#cardId#,phone=#phone#,birthdate=#birthdate#,state=#state#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(userId)){
	 and user_id=#userId#
	@}
	@if(!isEmpty(userName)){
	 and user_name=#userName#
	@}
	@if(!isEmpty(deptId)){
	 and dept_id=#deptId#
	@}
	@if(!isEmpty(password)){
	 and password=#password#
	@}
	@if(!isEmpty(cardId)){
	 and card_id=#cardId#
	@}
	@if(!isEmpty(phone)){
	 and phone=#phone#
	@}
	@if(!isEmpty(birthdate)){
	 and birthdate=#birthdate#
	@}
	@if(!isEmpty(state)){
	 and state=#state#
	@}
	
	