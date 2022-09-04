import "../styles/globals.css";
import type { AppProps } from "next/app";
import { useEffect } from "react";
import AxiosInstance from "../utils/axios/AxiosInstance";
import { store } from "src/redux/store";
import { setAccessToken } from "src/redux/reducers/authReducer";

function MyApp({ Component, pageProps }: AppProps) {
  useEffect(() => {
    AxiosInstance({
      url: "/user",
      method: "GET",
    })
      .then((res) => {
        console.log("성공");
        store.dispatch(setAccessToken(res.data.accessToken));
      })
      .catch((err) => {
        console.log("실패");
        console.log(err);
      });
  }, []);

  return <Component {...pageProps} />;
}

export default MyApp;
