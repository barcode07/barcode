import OutSideBarPresenter from "./presenter";

interface IOutSideBarProps {
  dummy: { name: string; member: string[] }[];
  onClickMoveToMain: () => void;
  onClickMoveToChannel: (event: React.MouseEvent<HTMLDivElement>) => void;
}

export default function OutSideBarContainer(props: IOutSideBarProps) {
  return (
    <OutSideBarPresenter
      dummy={props.dummy}
      onClickMoveToMain={props.onClickMoveToMain}
      onClickMoveToChannel={props.onClickMoveToChannel}
    />
  );
}
