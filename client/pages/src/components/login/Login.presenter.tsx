import Link from "next/link";
import React from "react";
import * as Lo from "./Login.styles";
import { ILoginUI } from "./Login.types";

export default function LoginUI(props: ILoginUI) {
  return (
    <Lo.Wrapper onSubmit={props.handleSubmit(props.onClickSubmit)}>
      <Lo.LoginWrapper>
        <Lo.Title>Bar_Code에 오신 여러분을 환영합니다!!</Lo.Title>
        <Lo.LoginEmailWrapper>
          <Lo.Label>이메일 </Lo.Label>
          <Lo.Input
            type="text"
            placeholder="이메일을 입력해주세요!"
            ref={props.inputEl}
          />
          <Lo.Error>{props.formState.errors.email?.message}</Lo.Error>
        </Lo.LoginEmailWrapper>
        <Lo.LoginPasswordWrapper>
          <Lo.Label>비밀번호 </Lo.Label>
          <Lo.Input type="password" placeholder="비밀번호를 입력해주세요!" />
          <Lo.Error>{props.formState.errors.password?.message}</Lo.Error>
        </Lo.LoginPasswordWrapper>

        <Lo.SignUpWrapper>
          <Lo.SignUpTitle>계정이 없으신가요?</Lo.SignUpTitle>
          <Link href="/signup">
            <Lo.SignUp>회원가입</Lo.SignUp>
          </Link>
        </Lo.SignUpWrapper>

        <Lo.LoginButton type="submit">로그인</Lo.LoginButton>
      </Lo.LoginWrapper>
    </Lo.Wrapper>
  );
}
