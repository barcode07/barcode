import { useRouter } from "next/router";
import SignupUI from "./Signup.presenter";

const Signup = () => {
  const router = useRouter();

  const onClickMoveLogin = () => {
    router.push("/");
  };
  return <SignupUI onClickMoveLogin={onClickMoveLogin} />;
};
export default Signup;
