package jp.co.htkk.batch.dto.base.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jp.co.htkk.batch.constant.Constant;
import jp.co.htkk.batch.util.Dates;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class BaseResponse {

	private String runnerName;
	private long startTime;
	private long endTime;
	private Date startDate;
	private Date endDate;
	private long runTimeMillis;
	private Object response;
	private String errorMessage;

	public BaseResponse(Class<?> runnerClass) {
		runnerName = runnerClass.getName();
		startTime = System.currentTimeMillis();
		startDate = Dates.now();
	}

	public void finish() {
		finish(null);
	}

	public void finish(Object response) {
		endTime = System.currentTimeMillis();
		endDate = Dates.now();
		runTimeMillis = endTime - startTime;
		this.response = response;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setDateFormat(new SimpleDateFormat(Constant.DATE.TIMESTAMP_FORMAT));
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
