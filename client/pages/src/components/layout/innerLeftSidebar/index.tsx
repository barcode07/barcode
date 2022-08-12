import InnerLeftSideBarContainer from "./container";

interface IInnerLeftSideBarProps {
  inServer: boolean;
}

export default function InnerLeftSideBar(props: IInnerLeftSideBarProps) {
  return <InnerLeftSideBarContainer inServer={props.inServer} />;
}
