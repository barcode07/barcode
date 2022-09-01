import InnerRightSideBarPresenter from "./presenter";

interface IRightSideBarProps {
  dummy: { name: string; member: string[] }[];
  serverName: string;
}

export default function InnerRightSideBarContainer(props: IRightSideBarProps) {
  return (
    <InnerRightSideBarPresenter
      dummy={props.dummy}
      serverName={props.serverName}
    />
  );
}
