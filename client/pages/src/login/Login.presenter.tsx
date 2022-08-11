import React from "react";
import * as Lo from "./Login.styles";

export default function LoginUI() {
  return (
    <Lo.Wrapper>
      <Lo.LoginWrapper>
        <Lo.Title>Bar_Code에 오신 여러분을 환영합니다!!</Lo.Title>
        <Lo.LoginEmailWrapper>
          <Lo.Label>이메일 :</Lo.Label>
          <Lo.Input type="text" placeholder="이메일을 입력해주세요!" />
        </Lo.LoginEmailWrapper>
        <Lo.LoginPasswordWrapper>
          <Lo.Label>비밀번호 : </Lo.Label>
          <Lo.Input type="password" placeholder="비밀번호를 입력해주세요!" />
        </Lo.LoginPasswordWrapper>

        <Lo.SignUpWrapper>
          <Lo.SignUpTitle>계정이 없으신가요?</Lo.SignUpTitle>
          <Lo.SignUp>회원가입</Lo.SignUp>
        </Lo.SignUpWrapper>

        <Lo.LoginButton type="submit">로그인</Lo.LoginButton>
      </Lo.LoginWrapper>
    </Lo.Wrapper>
  );
}
