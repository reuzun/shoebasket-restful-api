package ceng.estu.group2.shoebasketweb;

import ceng.estu.group2.shoebasketweb.business.abstracts.ModelService;
import ceng.estu.group2.shoebasketweb.requests.ModelRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.transaction.Transactional;


//@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class ShoebasketwebApplicationTests {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ModelService modelService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }


    @Test
    public void getRandomModels() throws Exception {

        this.mockMvc.perform(get("/api/models/random").param("limit", "1"))
                .andExpect(status().isOk())
                .andDo(document("model/getRandomModels",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data[].modelId").description("Id of the model.").optional(),
                                fieldWithPath("data[].modelName").description("Name of the model.").optional(),
                                fieldWithPath("data[].brandName").description("brand of the model.").optional(),
                                fieldWithPath("data[].type").description("type of the model").optional(),
                                fieldWithPath("data[].price").description("price of the model.").optional(),
                                fieldWithPath("data[].colors").description("available colors of the model.").optional(),
                                fieldWithPath("data[].sizes").description("available sizes of the model.").optional()

                        ),
                        requestParameters(
                                parameterWithName("limit").description("Bring n random items. Default = 10")
                        )
                ));
    }


    @Test
    public void getShoesOfModel() throws Exception {

        this.mockMvc.perform(get("/api/models/{modelId}/shoes", 1111))
                .andExpect(status().isOk())
                .andDo(document("model/getShoesOfModel",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data[].shoeId").description("Id of the shoe.").optional(),
                                fieldWithPath("data[].size").description("Size of the shoe.").optional(),
                                fieldWithPath("data[].color").description("Color of the shoe.").optional(),
                                fieldWithPath("data[].count").description("Count of the shoe").optional(),
                                fieldWithPath("data[].model.modelId").description("Id of the model.").optional(),
                                fieldWithPath("data[].model.modelName").description("Name of the model.").optional(),
                                fieldWithPath("data[].model.brandName").description("brand of the model.").optional(),
                                fieldWithPath("data[].model.type").description("type of the model").optional(),
                                fieldWithPath("data[].model.price").description("price of the model.").optional(),
                                fieldWithPath("data[].model.customerRating").description("rating of the model.").optional()
                                //fieldWithPath("data[].colors").description("available colors of the model.").optional(),
                                //fieldWithPath("data[].sizes").description("available sizes of the model.").optional()

                        ),
                        pathParameters(
                                parameterWithName("modelId").description("Id of the model to list shoes of it. (Required)")
                        )
                ));
    }

    @Test
    public void rateModel() throws Exception {

        this.mockMvc.perform(get("/api/models/{modelId}/shoes", 1111))
                .andExpect(status().isOk())
                .andDo(document("model/getShoesOfModel",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data[].shoeId").description("Id of the shoe.").optional(),
                                fieldWithPath("data[].size").description("Size of the shoe.").optional(),
                                fieldWithPath("data[].color").description("Color of the shoe.").optional(),
                                fieldWithPath("data[].count").description("Count of the shoe").optional(),
                                fieldWithPath("data[].model.modelId").description("Id of the model.").optional(),
                                fieldWithPath("data[].model.modelName").description("Name of the model.").optional(),
                                fieldWithPath("data[].model.brandName").description("brand of the model.").optional(),
                                fieldWithPath("data[].model.type").description("type of the model").optional(),
                                fieldWithPath("data[].model.price").description("price of the model.").optional(),
                                fieldWithPath("data[].model.customerRating").description("rating of the model.").optional()
                        ),
                        pathParameters(
                                parameterWithName("modelId").description("Id of the model to list shoes of it. (Required)")
                        )
                ));
    }


    @Test
    public void addModel() throws Exception {

        ModelRequest modelRequest = new ModelRequest();
        modelRequest.setBrandName("Quartz");
        modelRequest.setModelName("Melqu");
        modelRequest.setPrice(144);
        modelRequest.setType("Heel");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(modelRequest);


        this.mockMvc.perform(post("/api/models").contentType(MediaType.APPLICATION_JSON)
                .content(json)
            )
                .andExpect(status().isOk())
                .andDo(document("model/addModel",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional()
                        )
                        ,
                        requestFields(
                                fieldWithPath("brandName").description("Name of the Brand."),
                                fieldWithPath("modelName").description("Name of the Model."),
                                fieldWithPath("type").description("Type of Model."),
                                fieldWithPath("price").description("Price of Model.")
                        )
                ));
    }

    @Test
    public void deleteModel() throws Exception {

        int modelIdToDelete = modelService.getAllByModelNameAndBrandNameOrderByModelIdDesc("Melqu", "Quartz")
                .getData().get(0)
                .getModelId();

        this.mockMvc.perform(delete("/api/models/{id}", modelIdToDelete))
                .andExpect(status().isOk())
                .andDo(document("model/deleteModel",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional()
                        )
                        ,
                        pathParameters(
                                parameterWithName("id").description("Id of the Model.")
                        )
                ));
    }

}
