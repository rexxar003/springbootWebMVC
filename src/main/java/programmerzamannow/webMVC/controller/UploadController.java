package programmerzamannow.webMVC.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @PostMapping(path = "/upload/profile", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String upload(
            @RequestParam(name = "name") String name,
            @RequestPart(name = "profile" ) MultipartFile file) throws IllegalStateException, IOException {
        java.nio.file.Path path = java.nio.file.Path.of("upload/" + file.getOriginalFilename());

        file.transferTo(path);

        return "succes save profile "+name + " to " + path;
    }

}
