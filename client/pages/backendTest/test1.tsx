import AxiosInstance from "@/utils/axios/AxiosInstance";
import styled from "@emotion/styled";
import { setAccessToken } from "src/redux/reducers/authReducer";
import { store } from "src/redux/store";

/**
 * Author : Sukyung Lee
 * FileName: test1.tsx
 * Date: 2022-08-18 04:24:19
 * Description :
 */

// Axios 객체를 만들어서 로그인 API를 사용하는 예제
const Test1 = () => {
  const submitLogin = () => {
    AxiosInstance({
      url: "/user/test",
      method: "GET",
    })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const submitLogin1 = () => {
    AxiosInstance({
      url: "/user/login",
      method: "POST",
      data: {
        email: "dobby@dobby.com",
        password: "P@ssw0rd!",
      },
    })
      .then((res) => {
        store.dispatch(setAccessToken(res.data.accessToken));
        alert("로그인에 성공하였습니다.");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <Container>
      <div>
        <button onClick={submitLogin}> 버튼이다 </button>{" "}
        <button onClick={submitLogin1}> 버튼이다1 </button>{" "}
      </div>
      <div> </div>
    </Container>
  );
};
export default Test1;
const Container = styled.div`
  width: 100%;
`;
