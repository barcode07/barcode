import BodyContainer from "./presenter";

interface ILayOutBodyProps {
  rightBarHide: boolean;
}

export default function Body(props: ILayOutBodyProps) {
  return <BodyContainer rightBarHide={props.rightBarHide} />;
}
