import Link from "next/link";
import * as Si from "./Signup.styles";
import { ISignupUI } from "./Signup.types";

const SignupUI = (props: ISignupUI) => {
  return (
    <Si.Wrapper onSubmit={props.handleSubmit(props.onClickSubmit)}>
      <Si.SignupWrapper>
        <Si.Title>Bar_Code에서 여러분을 기다립니다!!</Si.Title>
        <Si.SignupUserNameWrapper>
          <Si.Label>사용자 이름 </Si.Label>
          <Si.Input
            type="text"
            placeholder="이름을 입력해주세요!"
            ref={props.inputEl}
          />
          <Si.Error>{props.formState.errors.name?.message}</Si.Error>
        </Si.SignupUserNameWrapper>
        <Si.SignupEmailWrapper>
          <Si.Label>이메일 </Si.Label>
          <Si.Input type="text" placeholder="이메일을 입력해주세요!" />
          <Si.Error>{props.formState.errors.email?.message}</Si.Error>
        </Si.SignupEmailWrapper>
        <Si.LoginPasswordWrapper>
          <Si.Label>비밀번호 </Si.Label>
          <Si.Input type="password" placeholder="비밀번호를 입력해주세요!" />
          <Si.Error>{props.formState.errors.password?.message}</Si.Error>
        </Si.LoginPasswordWrapper>

        <Si.LoginWrapper>
          <Si.LoginTitle>계정이 있으신가요?</Si.LoginTitle>
          <Link href="/">
            <Si.Login>로그인하기</Si.Login>
          </Link>
        </Si.LoginWrapper>

        <Si.SignupButton type="submit">회원가입</Si.SignupButton>
      </Si.SignupWrapper>
    </Si.Wrapper>
  );
};
export default SignupUI;
