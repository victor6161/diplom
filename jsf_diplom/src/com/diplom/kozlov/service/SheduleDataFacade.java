package com.diplom.kozlov.service;



public class SheduleDataFacade {
	private SheduleController sheduleController;

	public SheduleDataFacade(SheduleController sheduleController) {
		this.sheduleController = sheduleController;
	}

	//private static final Logger LOGGER = Logger.getLogger(SheduleDataFacade.class);

	public void init() {

	/*	List<SheduleDto> sheduleDto = sheduleController.getSheduleService().getShedule();
		List<RowBean> rowsBean = new ArrayList<RowBean>();
		for (SheduleDto route : sheduleDto) {
			rowsBean.add(sheduleController.getMapper().dtoToRowBean(route));
		}
		sheduleController.getMainBean().setRowsBean(rowsBean);*/
	}

	public void add() {
/*		LOGGER.info("add");
		AddBean addBean = sheduleController.getMainBean().getAddBean();

		SheduleDto sheduleDto = sheduleController.getMapper().addBeanToDto(addBean);
		
		sheduleController.getSheduleService().save(sheduleDto);
		init();*/

	}



	public void onAddOpen() {
	/*	LOGGER.info("edit");
		sheduleController.getMainBean().setAddBean(new AddBean());*/

	}

	public void edit() {
		//LOGGER.info("edit");
/*		EditorBean editorBean = sheduleController.getMainBean().getEditorBean();
		SheduleDto sheduleDto = sheduleController.getMapper().editorBeanToDto(editorBean);
		sheduleController.getSheduleService().update(sheduleDto);
		init();*/
	}

	public void onEditOpen() {
		//LOGGER.info("onEditOpen");
/*		RowBean rowBean = sheduleController.getMainBean().getSelectedRoute();
	 	SheduleDto sheduleDto = sheduleController.getMapper().rowBeanToDto(rowBean);
	 	EditorBean editorBean = sheduleController.getMapper().sheduleDtoToEditorBean(sheduleDto);
	 	sheduleController.getMainBean().setEditorBean(editorBean);*/
	 	
		
	}

}
