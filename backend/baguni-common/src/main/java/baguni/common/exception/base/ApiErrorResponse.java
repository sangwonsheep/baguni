package baguni.common.exception.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiErrorResponse extends ResponseEntity<ApiErrorBody> {

	private ApiErrorResponse(ApiErrorCode apiErrorCode) {
		super(
			new ApiErrorBody(apiErrorCode.getCode(), apiErrorCode.getMessage()),
			apiErrorCode.getHttpStatus()
		);
	}

	private ApiErrorResponse(String code, String message, HttpStatus status) {
		super(new ApiErrorBody(code, message), status);
	}

	public static ApiErrorResponse of(ApiErrorCode apiErrorCode) {
		return new ApiErrorResponse(apiErrorCode);
	}

	public static ApiErrorResponse VALIDATION_ERROR(String message) {
		return new ApiErrorResponse("VALIDATION ERROR", message, HttpStatus.BAD_REQUEST);
	}

	public static ApiErrorResponse UNKNOWN_SERVER_ERROR() {
		return new ApiErrorResponse("UNKNOWN", "미확인 서버 에러", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ApiErrorResponse INVALID_JSON_ERROR() {
		return new ApiErrorResponse("INVALID JSON ERROR", "올바르지 않은 Json 형식입니다.", HttpStatus.BAD_REQUEST);
	}

	public static ApiErrorResponse INVALID_REQUEST_PARAMETER() {
		return new ApiErrorResponse("INVALID REQUEST PARAMETER", "올바르지 않은 Request Parameter 형식입니다.",
			HttpStatus.BAD_REQUEST);
	}
}
