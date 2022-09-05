import "../styles/globals.css";
import type { AppProps } from "next/app";
import { useEffect } from "react";
import AxiosInstance from "../utils/axios/AxiosInstance";
import { store } from "src/redux/store";
import { setAccessToken } from "src/redux/reducers/authReducer";
import { useRouter } from "next/router";
import { setUserInfo } from "src/redux/reducers/userReducer";

const routerMovePath = ["/", "/login", "/signup"];

function MyApp({ Component, pageProps }: AppProps) {
  const router = useRouter();
  useEffect(() => {
    AxiosInstance({
      url: "/user/accessToken",
      method: "GET",
    })
      .then(async (res) => {
        console.log("처음에 유저 정보 받아오기 성공");
        store.dispatch(setAccessToken(res.data.accessToken));
        await AxiosInstance({
          url: "/user",
          method: "GET",
          headers: {
            Authorization: `Bearer ${store.getState().auth.accessToken}`,
          },
        })
          .then((response) => {
            store.dispatch(
              setUserInfo({
                userId: response.data.data.user.userId,
                email: response.data.data.user.email,
                nickname: response.data.data.user.nickname,
              })
            );
            routerMovePath.map((i: any) => {
              if (i === router.asPath) {
                router.push("/main");
              }
            });
          })
          .catch((error) => {});
      })
      .catch((error) => {
        // 리프레시 토큰이 없거나 만료? 되었을 경우 이곳으로 온다.
        if (routerMovePath.some((i: any) => i === router.asPath)) return;
        console.log(error);
        alert("로그인이 필요합니다.");
        router.push("/");
      });
  }, []);

  return <Component {...pageProps} />;
}

export default MyApp;
