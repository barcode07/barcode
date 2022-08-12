import styled from "styled-components";

export const Wrapper = styled.form`
  width: 100vw;
  height: 100vh;
  display: flex;
  align-items: center;
  background-image: url("/images/barcode.png");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
`;

export const SignupWrapper = styled.div`
  width: calc(100% - 30%);
  height: 540px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  border: none;
  border-radius: 40px;
  padding: 10px 50px;
  background: #f5f5f5;
  margin-top: -140px;
  margin-left: auto;
  margin-right: auto;
`;

export const Title = styled.h1``;

//  사용자 이름
export const SignupUserNameWrapper = styled.div`
  width: 100%;
`;

//  회워가입 아이디
export const SignupEmailWrapper = styled.div`
  width: 100%;
  padding-top: 10px;
`;

export const Label = styled.div`
  font-size: 16px;
  font-weight: 500;
  padding-bottom: 5px;
`;

export const Input = styled.input`
  width: 100%;
  height: 45px;
  padding-left: 20px;
  font-size: 16px;
  border: 1px solid #000000;
  border-radius: 20px;
  ::placeholder {
    font-size: 12px;
    color: #999999;
    padding-left: 10px;
    transition: all 0.5s ease-in-out;
  }
  :focus::placeholder {
    color: transparent;
  }
`;

export const LoginPasswordWrapper = styled.div`
  width: 100%;
  padding-top: 10px;
`;

// 로그인창 이동
export const LoginWrapper = styled.div`
  width: 100%;
  display: flex;
  padding-top: 10px;
`;
export const LoginTitle = styled.div`
  font-size: 16px;
`;
export const Login = styled.div`
  font-size: 16px;
  margin-left: 30px;
  cursor: pointer;
`;

// 회원가입 버튼
export const SignupButton = styled.button`
  width: calc(100% - 30%);
  height: 50px;
  border: none;
  border-radius: 20px;
  font-size: 24px;
  cursor: pointer;
`;

export const Error = styled.div`
  font-size: 12px;
  font-weight: 700;
  padding-top: 10px;
  padding-left: 20px;
  color: red;
`;
