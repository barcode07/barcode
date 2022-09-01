import { useEffect, useRef } from "react";
import SignupUI from "./Signup.presenter";
import * as yup from "yup";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { useRouter } from "next/router";
import AxiosInstance from "@/utils/axios/AxiosInstance";

const schema = yup.object({
  nickname: yup.string().required("필수 입력 사항입니다!!"),
  email: yup
    .string()
    .email("이메일 형식이 아닙니다.")
    .required("필수 입력 사항입니다!!"),
  password: yup
    .string()
    .matches(
      /^(?=.*[a-zA-z])(?=.*\d)(?=.*[$@#!~%^&*])[a-zA-Z\d$@#!~%^&*]{8,15}$/,
      "비밀번호는 8 ~ 15자 이며 영문, 숫자, 특수문자를 포함해야 합니다."
    )
    .required("필수 입력 사항입니다!!"),
});

const Signup = () => {
  const { register, handleSubmit, formState } = useForm({
    resolver: yupResolver(schema),
    mode: "onChange",
    defaultValues: {
      email: "dobby@dobby.com",
      password: "P@ssw0rd!",
      nickname: "dobby",
    },
  });
  const router = useRouter();
  const inputEl = useRef<HTMLInputElement>(null as any);

  useEffect(() => {
    inputEl.current?.focus();
  }, []);

  const onClickSubmit = (data: any) => {
    AxiosInstance({
      url: "/user/signup",
      method: "POST",
      data: {
        email: data.email,
        password: data.password,
        nickname: data.nickname,
      },
    })
      .then((res: any) => {
        alert("회원가입에 성공하였습니다.");
        router.push("/");
      })
      .catch((err: any) => {
        alert(err.response.data.msg);
        // console.log(err.response.data.msg);
      });
  };

  return (
    <SignupUI
      inputEl={inputEl}
      handleSubmit={handleSubmit}
      register={register}
      formState={formState}
      onClickSubmit={onClickSubmit}
    />
  );
};
export default Signup;
