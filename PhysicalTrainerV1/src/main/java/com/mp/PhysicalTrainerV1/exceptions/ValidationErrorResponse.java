package com.mp.PhysicalTrainerV1.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ValidationErrorResponse {
  List<Violation> violations = new ArrayList<>();

  @JsonProperty("error_description")
  private String errorDescription =
      "Invalid entries found in the submitted form. Please try again.";

  @JsonProperty("error_type")
  private String errorType = "BAD REQUEST";

  @JsonProperty("error_code")
  private String errorCode = "EC-400";

  public boolean hasErrors() {
    return !violations.isEmpty();
  }

  @Data
  @AllArgsConstructor
  public static class Violation {
    String path;
    String message;
  }
}
