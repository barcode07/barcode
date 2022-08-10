import * as B from "./style";

interface ILayOutBodyProps {
  rightBarHide: boolean;
}

export default function BodyPresenter(props: ILayOutBodyProps) {
  return (
    <B.HTML rightBodyHide={props.rightBarHide}>
      <B.Body>바디</B.Body>
    </B.HTML>
  );
}
