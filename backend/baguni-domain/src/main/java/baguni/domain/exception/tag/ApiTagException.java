package baguni.domain.exception.tag;

import baguni.common.exception.base.ApiErrorCode;
import baguni.common.exception.base.ApiException;

public class ApiTagException extends ApiException {

	private ApiTagException(ApiErrorCode errorCode) {
		super(errorCode);
	}

	/**
	 * TODO: Implement static factory method
	 */

	public static ApiTagException TAG_NOT_FOUND() {
		return new ApiTagException(ApiTagErrorCode.TAG_NOT_FOUND);
	}

	public static ApiTagException TAG_ALREADY_EXIST() {
		return new ApiTagException(ApiTagErrorCode.TAG_ALREADY_EXIST);
	}

	public static ApiTagException TAG_INVALID_NAME() {
		return new ApiTagException(ApiTagErrorCode.TAG_INVALID_NAME);
	}

	public static ApiTagException UNAUTHORIZED_TAG_ACCESS() {
		return new ApiTagException(ApiTagErrorCode.UNAUTHORIZED_TAG_ACCESS);
	}

	public static ApiTagException TAG_INVALID_ORDER() {
		return new ApiTagException(ApiTagErrorCode.TAG_INVALID_ORDER);
	}

	public static ApiTagException TAG_NAME_TOO_LONG() {
		return new ApiTagException(ApiTagErrorCode.TAG_NAME_TOO_LONG);
	}

}
