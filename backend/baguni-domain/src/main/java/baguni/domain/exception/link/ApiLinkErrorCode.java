package baguni.domain.exception.link;

import org.springframework.http.HttpStatus;

import baguni.common.exception.base.ApiErrorCode;
import baguni.common.exception.level.ErrorLevel;

public enum ApiLinkErrorCode implements ApiErrorCode {

	/**
	 * Link Error Code (LI)
	 */
	LINK_NOT_FOUND
		("LI-000", HttpStatus.NOT_FOUND, "존재하지 않는 링크", ErrorLevel.SHOULD_NOT_HAPPEN()),

	LINK_HAS_PICKS
		("LI-001", HttpStatus.BAD_REQUEST, "링크를 픽한 사람이 존재", ErrorLevel.SHOULD_NOT_HAPPEN()),

	LINK_ALREADY_EXIST
		("LI-002", HttpStatus.BAD_REQUEST, "이미 존재하는 링크(URL)", ErrorLevel.CAN_HAPPEN()),

	LINK_OG_TAG_UPDATE_FAILURE
		("LI-003", HttpStatus.NOT_FOUND, "OG 태그 업데이트를 위한 크롤링 요청 실패", ErrorLevel.CAN_HAPPEN()),

	LINK_URL_TOO_LONG
		("LI-004", HttpStatus.URI_TOO_LONG, "저장 가능한 URL 길이 초과 [< 2048]", ErrorLevel.CAN_HAPPEN()),

	LINK_ANALYZE_FAILURE
		("LI-005", HttpStatus.URI_TOO_LONG, "링크 분석에 실패했습니다", ErrorLevel.CAN_HAPPEN()),
	;

	// ------------------------------------------------------------
	// 하단 코드는 모든 ApiErrorCode 들에 반드시 포함되야 합니다.
	// 새로운 ErrorCode 구현시 복사 붙여넣기 해주세요.

	private final String code;

	private final HttpStatus httpStatus;

	private final String errorMessage;

	private final ErrorLevel errorLevel;

	ApiLinkErrorCode(String code, HttpStatus status, String message, ErrorLevel errorLevel) {
		this.code = code;
		this.httpStatus = status;
		this.errorMessage = message;
		this.errorLevel = errorLevel;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}

	@Override
	public ErrorLevel getErrorLevel() {
		return this.errorLevel;
	}

	@Override
	public String toString() {
		return convertCodeToString(this);
	}
}
