import * as B from "./style";

interface ILayOutBodyProps {
  inServer: boolean;
}

export default function BodyPresenter(props: ILayOutBodyProps) {
  return (
    <B.HTML inServer={props.inServer}>
      <B.Body>바디</B.Body>
    </B.HTML>
  );
}
