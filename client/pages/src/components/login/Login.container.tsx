import { useEffect, useRef } from "react";
import LoginUI from "./Login.presenter";
import * as yup from "yup";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";

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
  });

  const inputEl = useRef<HTMLInputElement>(null as any);

  useEffect(() => {
    inputEl.current?.focus();
  }, []);

  const onClickSubmit = () => {
    console.log("하일");
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
