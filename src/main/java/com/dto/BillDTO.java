package com.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillDTO extends AbstractDTO<BillDTO> {
	private int idbill;
	private String country;
	private String city;
	private String county;
	private String hn;
	private String phone;
	private String date;
	private int total;
	private String username;
	private String products;
	private int status;
	private List<BillDTO> listResultTwo = new ArrayList<>();
	private List<BillDTO> listResultThree = new ArrayList<>();
}
