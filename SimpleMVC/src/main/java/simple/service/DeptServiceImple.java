package simple.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImple implements DeptService {
	private final static Logger LOG = LoggerFactory
			.getLogger(DeptServiceImple.class);
	
	@Override
	public String serviceMessage() {
		LOG.trace("service method 호출 됨..");
		return "service method";
	}

}
