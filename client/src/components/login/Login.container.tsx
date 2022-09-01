import { useEffect, useRef } from "react";
import LoginUI from "./Login.presenter";
import * as yup from "yup";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import AxiosInstance from "../../../utils/axios/AxiosInstance";
import { setAccessToken } from "../../redux/reducers/authReducer";
import { store } from "../../redux/store";
import { useRouter } from "next/router";

const schema = yup.object({
  email: yup
    .string()
    .email("이메일 형식이 아닙니다.")
    .required("이메일이 없으면 로그인이 불가해요 ㅜㅜ"),
  password: yup.string().required("비밀번호를 입력해주세요"),
});

export default function Login() {
  const { register, handleSubmit, formState } = useForm({
    resolver: yupResolver(schema),
    mode: "onChange",
    defaultValues: {
      email: "dobby@dobby.com",
      password: "P@ssw0rd!",
    },
  });

  const router = useRouter();
  const inputEl = useRef<HTMLInputElement>(null as any);

  useEffect(() => {
    inputEl.current?.focus();
  }, []);

  const onClickSubmit = (data: any) => {
    AxiosInstance({
      url: "/user/login",
      method: "POST",
      data: {
        email: data.email,
        password: data.password,
      },
    })
      .then((res) => {
        console.log("성공");
        store.dispatch(setAccessToken(res.data.accessToken));
        alert("로그인에 성공하였습니다.");
        router.push("/main");
      })
      .catch((err) => {
        console.log("실패");
        console.log(err);
      });
  };

  return (
    <LoginUI
      inputEl={inputEl}
      register={register}
      handleSubmit={handleSubmit}
      formState={formState}
      onClickSubmit={onClickSubmit}
    />
  );
}
