package com.barcode.server.barcode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : UserDto
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Schema(description = "사용자")
public class UserSignupDto {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Schema(description = "이메일", nullable = false, example = "dobby@dobby.com")
    @Pattern(regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$",
            message="example@test.com과 같은 이메일 형식이 아닙니다.")
    private String email;

    @NotEmpty
    @Schema(description = "비밀번호", nullable = false, example = "P@ssw0rd!")
    @Pattern(regexp="(?=.*\\d{1,15})(?=.*[~`!@#$%^&*()-+=]{1,15})(?=.*[a-zA-Z]{1,15})[a-zA-Z0-9~`!@#$%^&*()-+=]{8,15}$"
            ,message="8~15자리로 최소 영문1개, 숫자1개, 특수문자1개로 구성되야합니다.")
    private String password;

    @NotEmpty
    @Schema(description = "닉네임", nullable = false, example = "도비")
    @Pattern(regexp="^[가-힣a-zA-Z0-9]{2,8}$"
            ,message="한글,숫자,영문으로 2~8글자 사이로 구성되었습니다.")
    private String nickname;
}
