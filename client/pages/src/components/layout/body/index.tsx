import BodyContainer from "./presenter";

interface ILayOutBodyProps {
  inServer: boolean;
}

export default function Body(props: ILayOutBodyProps) {
  return <BodyContainer inServer={props.inServer} />;
}
