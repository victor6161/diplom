package com.diplom.kozlov.rest;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



import com.diplom.kozlov.db.service.VesselServiceImpl;
import com.iba.kozlov.web.VesselDtoJson;
import com.iba.kozlov.web.VesselsData;

import com.diplom.kozlov.db.dto.VesselDto;


@Path("demo")
public class VesselRestService {
	
	VesselServiceImpl vesselService = new VesselServiceImpl();
	Mapper mapper = new Mapper();

	@GET
	@Path("all_books")
	@Produces(MediaType.APPLICATION_JSON)
	public VesselsData getBooks() {
		List<VesselDto> vesselDtoDb = vesselService.getVessels();
		VesselsData booksData = getRoute(vesselDtoDb);
		return booksData;
	}

/*	@GET
	@Path("all_books_by_author")
	@Produces(MediaType.APPLICATION_JSON)
	public BooksData getBooksByAuthor(@QueryParam("id") Integer id) {
		BookDto bookDto = new BookDto();
		WriterDto writerDto = new WriterDto();

		writerDto.setId(id);
		List<WriterDto> writersDto = new ArrayList<WriterDto>();
		writersDto.add(writerDto);
		bookDto.setWriters(writersDto);

		List<BookDto> bookDtoDb = routeService.searchBooks(bookDto);
		BooksData booksData = getBook(bookDtoDb);
		return booksData;

	}*/
	public VesselsData getRoute(List<VesselDto> bookDtoDb){
		List<VesselDtoJson> vesselDtoJson = new ArrayList<VesselDtoJson>();
		for (VesselDto bookDtoItem : bookDtoDb) {
			vesselDtoJson.add(mapper.vesselDtoToDtoJson(bookDtoItem));
		}
		
		VesselsData booksData = new VesselsData();
		booksData.setBooks(vesselDtoJson);
		return booksData;
	}

}
