package de.uniba.dsg.serverless.file.transfer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {

  @Value("${calibration.path}")
  private String calibrationPath;

  public List<String> readAllLines(String fileName) throws IOException {
      return Files.readAllLines(Path.of(calibrationPath, fileName));
  }
}
