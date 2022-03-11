package de.uniba.dsg.serverless.file.transfer;

import java.io.IOException;
import java.util.List;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/files")
public class FileController {

  @Autowired
  private FileService fileService;

  @GetMapping
  public ResponseEntity<List<String>> getFile(@RequestParam(required = true, name = "name") String fileName) {

    List<String> lines = null;
    try {
      lines = fileService.readAllLines(fileName);
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(lines);
  }
}
