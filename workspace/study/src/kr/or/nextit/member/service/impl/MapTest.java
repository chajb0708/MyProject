package kr.or.nextit.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import kr.or.nextit.member.service.MemberVo;

public class MapTest {
	
	public static void main(String[] args) {
		
		HashMap<String, Object> parameterType = new HashMap<>();
		parameterType.put("1", new MemberVo());
		parameterType.put("2", new MemberVo());
		parameterType.put("3", new MemberVo());
		parameterType.put("4", new MemberVo());
		parameterType.put("5", new MemberVo());
		
		List<MemberVo> memberList = new ArrayList<>();
		
		Set<String> keys = parameterType.keySet();
		for(String key : keys) {
			System.out.println(key);
			System.out.println(parameterType.get(key));
			memberList.add((MemberVo)parameterType.get(key));
		}
		
		HashMap<String, Object> resultType = new HashMap<>();
		
		MemberVo memberVo = new MemberVo();
		memberVo.setUserId("");
		
		HashMap<String, Object> vo = new HashMap<>();
		vo.put("userId", memberVo.getUserId());
		vo.put("userName", memberVo.getUserName());
		vo.put("userEmail", memberVo.getUserEmail());
	}

}
