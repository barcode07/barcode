import axios from "axios";

const AxiosInstance = axios.create({
  //baseURL: 'http://localhost:8080',
  //timeout: 1000,
  baseURL: "http://barcode-server.ssssksss.xyz",
  headers: {
    "Content-Type": "application/json",
    // 프론트엔드에서 Cors 문제를 해결하기 위한 방법
    // 아래 withCredentials하고 allow-Origin 정도만 해주면 프론트엔드에서 Cors문제는 해결되었다고 보면된다.
    // 안된다면 백엔드분들을 달달 볶으면 된다.
    "Access-Control-Allow-Origin": "*",
  },
  // 프론트 엔드에서 withCredentials을 해주지 않는다면
  // 쿠키가 저장이 되지 않는다. 그리고 백엔드에서도 withCredentials을 true로 설정을 해주어야한다.
  withCredentials: true,
});

// axios의 인터셉터라고 하여 axios에서 응답을 보내고 요청을 받을때 처리를 해주는 로직을 작성할 수 있다.
// 아마 사용은 제대로 안해봤지만 accessToken 만료와 같은 상황에 대해서 에러를 받고 accessToken을 요청하는 로직을 작성할 수 있다고 본다.
// 사용법은 알아서 알아봐야 할 것이다.
AxiosInstance.interceptors.response.use(
  function (response) {
    console.log("이거 작동되던가???");
    return response;
  },
  function (error) {
    //토큰 만료 에러가 발생하면 로그인 페이지로 이동시키게 한다.
    return Promise.reject(error);
  }
);

export default AxiosInstance;
