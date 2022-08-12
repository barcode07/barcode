import { useRouter } from "next/router";
import LoginUI from "./Login.presenter";

export default function Login() {
  const router = useRouter();

  const onClickMoveSignup = () => {
    router.push("/signup");
  };
  return <LoginUI onClickMoveSignup={onClickMoveSignup} />;
}
