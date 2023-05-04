package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cust {
    @Size(min=4, max=10, message = "id는 최소 4자리  최대 10자리 입니다")
    //내가 정한 사이즈 외에 에러
    @NotEmpty(message = "id는 필수항목입니다.")
    private String id;
    @Size(min=5, max=10, message = "id는 최소 5자리  최대 10자리 입니다")
    @NotEmpty(message = "pwd는 필수항목입니다.")
    private String pwd;
    @NotEmpty(message = "name는 필수항목입니다.")
    private String name;
}
