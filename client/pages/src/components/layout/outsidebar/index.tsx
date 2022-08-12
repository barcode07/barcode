import OutSideBarContainer from "./container";

interface IOutSideBarProps {
  onClickMoveToMain: () => void;
  onClickMoveToChannel: (event: React.MouseEvent<HTMLDivElement>) => void;
  dummy: { name: string; member: string[] }[];
}

export default function OutSideBar(props: IOutSideBarProps) {
  return (
    <OutSideBarContainer
      dummy={props.dummy}
      onClickMoveToMain={props.onClickMoveToMain}
      onClickMoveToChannel={props.onClickMoveToChannel}
    />
  );
}
