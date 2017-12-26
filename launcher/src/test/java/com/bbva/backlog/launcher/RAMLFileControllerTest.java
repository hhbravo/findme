package com.bbva.backlog.launcher;

import com.bbva.backlog.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RAMLFileControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

 /*   @Ignore
    @Test
    public void testImportRAMLFile() throws Exception {
        assertEquals(HttpStatus.CREATED, this.restTemplate.postForEntity(
                "http://localhost:" + port + "/importRAMLFile", getMockMultipartFile(), Object.class).getStatusCode());
    }

    @Ignore
    @Test
    public void testGetMultichannelServicesByModelingFileId() throws Exception {
        final ResponseEntity<Object> responseEntity = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/businessServices/modelingFiles/1", Object.class);
        final List<MultichannelService> multichannelServices = (List<MultichannelService>) responseEntity.getBody();
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(multichannelServices, is(not(empty())));
    }

    @Ignore
    @Test
    public void testImportMultichannelServiceSpreadsheetFile() throws Exception {
        Map<String, Object> body = new HashMap<>();
        body.put("keys", Arrays.asList(new Integer(1)).toArray());
        body.put("files", Arrays.asList(getMockMultipartFile()).toArray());
        assertEquals(HttpStatus.OK, this.restTemplate.postForEntity(
                "http://localhost:" + port + "/importMultichannelServiceSpreadsheetFile", body, Object.class).getStatusCode());
    }

    private MultiValueMap<String, Object> getMockMultipartFile() throws IOException, URISyntaxException {
        final String filename = "util.zip";
        byte[] file = Files.readAllBytes(PathUtils.getResourceFilePathFromContextClassLoader(filename));
        final ByteArrayResource contentsAsResource = new ByteArrayResource(file) {
            @Override
            public String getFilename() {
                return filename;
            }
        };
        return new LinkedMultiValueMap<String, Object>() {{
            add("name", filename);
            add("filename", filename);
            add("file", contentsAsResource);
        }};
    }*/

}