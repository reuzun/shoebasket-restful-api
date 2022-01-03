package ceng.estu.group2.shoebasketweb;

import ceng.estu.group2.shoebasketweb.business.abstracts.ModelService;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
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
import org.springframework.test.context.ActiveProfiles;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
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
@ActiveProfiles("test")
class ShoeBasketModelOperationsTest {

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
    public void addModel() throws Exception {

        ModelRequest modelRequest = new ModelRequest();
        modelRequest.setBrandName("Quartzasdzxc");
        modelRequest.setModelName("Melqu123qwe");
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
    public void updateModel() throws Exception {
        int modelIdToDelete = modelService.getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc("ol2nyvlk", "Adidas")
                .getData().get(0)
                .getModelId();

        ModelRequest modelRequest = new ModelRequest();
        modelRequest.setBrandName("Adidas");
        modelRequest.setModelName("ol2nyvlk");
        modelRequest.setPrice(144);
        modelRequest.setType("Heel");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(modelRequest);


        this.mockMvc.perform(put("/api/models/{id}", modelIdToDelete)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
                )
                .andExpect(status().isOk())
                .andDo(document("model/updateModel",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data.modelId").description("Id of the model.").optional(),
                                fieldWithPath("data.modelName").description("Name of the model.").optional(),
                                fieldWithPath("data.brandName").description("brand of the model.").optional(),
                                fieldWithPath("data.type").description("type of the model").optional(),
                                fieldWithPath("data.price").description("price of the model.").optional(),
                                fieldWithPath("data.customerRating").description("Rating of the model.").optional()
//                                fieldWithPath("data.shoeList[].shoeId").description("------").optional(),
//                                fieldWithPath("data.shoeList[].color").description("------").optional(),
//                                fieldWithPath("data.shoeList[].size").description("------").optional(),
//                                fieldWithPath("data.shoeList[].count").description("------").optional()

                        ),
                        pathParameters(
                                parameterWithName("id").description("Id of the Model.")
                        ),
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

        int modelIdToDelete = modelService.getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc("Melqu123qwe", "Quartzasdzxc")
                .getData().get(0)
                .getModelId();

        this.mockMvc.perform(delete("/api/models/{id}", modelIdToDelete))
                .andExpect(status().isOk())
                .andDo(document("model/deleteModel",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional()
                        ),
                        pathParameters(
                                parameterWithName("id").description("Id of the Model.")
                        )
                ));
    }


    @Test
    public void getModelById() throws Exception {

        this.mockMvc.perform(get("/api/models/{id}", 1))
                .andExpect(status().isOk())
                .andDo(document("model/getModelById",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data.modelId").description("Id of the model.").optional(),
                                fieldWithPath("data.modelName").description("Name of the model.").optional(),
                                fieldWithPath("data.brandName").description("brand of the model.").optional(),
                                fieldWithPath("data.type").description("type of the model").optional(),
                                fieldWithPath("data.price").description("price of the model.").optional(),
                                fieldWithPath("data.colors").description("available colors of the model.").optional(),
                                fieldWithPath("data.sizes").description("available sizes of the model.").optional()

                        ),
                        pathParameters(
                                parameterWithName("id").description("Id of the Model.")
                        )
                ));
    }


    @Test
    public void getModelRates() throws Exception {

        this.mockMvc.perform(get("/api/models/{id}/rates", 1))
                .andExpect(status().isOk())
                .andDo(document("model/getRates",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data[].username").description("Username of rater.").optional(),
                                fieldWithPath("data[].star").description("Rate.").optional()
                        ),
                        pathParameters(
                                parameterWithName("id").description("Id of the Model.")
                        )
                ));
    }


    @Test
    public void rateModel() throws Exception {
//        int modelIdToDelete = modelService.getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc("ol2nyvlk", "Adidas")
//                .getData().get(0)
//                .getModelId();

        int modelId = 1;
        RatedModelsDto ratedModelsDto = new RatedModelsDto();
        ratedModelsDto.setUsername("gercek");
        ratedModelsDto.setStar(3);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(ratedModelsDto);


        this.mockMvc.perform(put("/api/models/{id}/rates", modelId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
                .andExpect(status().isOk())
                .andDo(document("model/rateModel",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data.username").description("Username of rater.").optional(),
                                fieldWithPath("data.star").description("Rate").optional()

                        ),
                        pathParameters(
                                parameterWithName("id").description("Id of the Model.")
                        ),
                        requestFields(
                                fieldWithPath("username").description("Username of rater."),
                                fieldWithPath("star").description("Rate.")
                        )
                ));
    }


    @Test
    public void updatePrice() throws Exception {
//        int modelIdToDelete = modelService.getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc("ol2nyvlk", "Adidas")
//                .getData().get(0)
//                .getModelId();

        int modelId = 1;

        this.mockMvc.perform(patch("/api/models/{id}?price={val}", modelId, 180)/*.param("price", "165")*/)
                .andExpect(status().isOk())
                .andDo(document("model/updatePrice",
                        links(),
                        responseFields(
                                fieldWithPath("success").description("Is there any error about API?").optional(),
                                fieldWithPath("message").description("Message of api answer.").optional(),
                                fieldWithPath("data.modelId").description("Id of the model.").optional(),
                                fieldWithPath("data.modelName").description("Name of the model.").optional(),
                                fieldWithPath("data.brandName").description("brand of the model.").optional(),
                                fieldWithPath("data.type").description("type of the model").optional(),
                                fieldWithPath("data.price").description("price of the model.").optional(),
                                fieldWithPath("data.customerRating").description("Rating of the model.").optional()

                        ),
                        pathParameters(
                                parameterWithName("id").description("Id of the Model.")
                        ),
                        requestParameters(
                                parameterWithName("price").description("price value to update.")
                        )
                ));
    }


}
