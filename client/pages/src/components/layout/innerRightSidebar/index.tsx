import InnerRightSideBarContainer from "./container";

interface IRightSideBarProps {
  dummy: { name: string; member: string[] }[];
  serverName: string;
}

export default function InnerRightSideBar(props: IRightSideBarProps) {
  return (
    <InnerRightSideBarContainer
      dummy={props.dummy}
      serverName={props.serverName}
    />
  );
}
