import InnerLeftSideBarContainer from "./container";

interface IInnerLeftSideBarProps {
  inServer: boolean;
  serverName: string;
}

export default function InnerLeftSideBar(props: IInnerLeftSideBarProps) {
  return (
    <InnerLeftSideBarContainer
      inServer={props.inServer}
      serverName={props.serverName}
    />
  );
}
