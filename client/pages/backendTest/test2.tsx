import styled from "@emotion/styled";
import axios from "axios";
/**
 * Author : Sukyung Lee
 * FileName: test2.tsx
 * Date: 2022-08-18 04:37:05
 * Description :
 */

const Test2 = () => {
  const submitLogin = () => {
    axios({
      url: "http://barcode-server.ssssksss.xyz/user/login",
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
      withCredentials: true,
      data: {
        email: "dobby@dobby.com",
        password: "P@ssw0rd!",
      },
    })
      .then((res) => {
        console.log(res.data);
        alert("로그인에 성공하였습니다.");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <Container>
      <div>
        {" "}
        <button onClick={submitLogin}> 버튼이다 </button>{" "}
      </div>
      <div> </div>
    </Container>
  );
};
export default Test2;
const Container = styled.div`
  width: 100%;
`;
