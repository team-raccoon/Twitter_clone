package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Util.CsvReader;
import dto.LoginUserInfDto;

public class UsersService extends Service{

	@Override
	public List<Map<String, String>> findAll() {
		return CsvReader.getCsvList("users");
	}

	public List<LoginUserInfDto> selectLoginUserInf() {
		List<LoginUserInfDto> dtoList = new ArrayList<LoginUserInfDto>();
		List<Map<String, String>> csvList = findAll();
		csvList.stream().forEach(map ->{
			LoginUserInfDto dto = new LoginUserInfDto();
			dto.setUsersEmail(map.get("email"));
			dto.setUsersPassword(map.get("password"));
			dto.setUsersName(map.get("nickname"));
			dtoList.add(dto);
		});
		return dtoList;
	}
}
