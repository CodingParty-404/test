package com.cp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import com.cp.commontest.CommonTest;
import com.cp.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTests extends CommonTest {
	@Autowired
	WebApplicationContext ctx;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testRegister() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "test title")
				.param("content", "test content").param("writer", "test writer")).andReturn().getModelAndView();
	}
	@Test
	public void testgetListTest() throws Exception {
		List<BoardVO> vo = (List<BoardVO>) mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn()
				.getModelAndView().getModel().get("list");
		log.info("model..................................................");
		vo.forEach(aa -> log.info(aa));
	}
	@Test
	public void readTest() throws Exception {
		log.info("readTest.................................");
		BoardVO vo = (BoardVO)
		mockMvc.perform(MockMvcRequestBuilders.get("/board/read").param("bno", "4839570"))
		.andReturn()
		.getModelAndView()
		.getModel()
		.get("onePost");

	}
	@Test
	public void removeTest() throws Exception
	{
		log.info("removeTest.....................................");
		mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "4839570"))
		.andReturn();
	}
}
