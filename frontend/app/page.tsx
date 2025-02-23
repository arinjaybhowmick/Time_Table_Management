import { Link } from "@heroui/link";
import { title, subtitle } from "@/app/utils/primitives";
import { Button } from "@heroui/button";

export default function Home() {
  return (
    <section className="flex flex-col items-center justify-center gap-4 py-8 md:py-10">
      <div className="inline-block max-w-xl text-center justify-center">
        <span className={title({ color: "violet" })}>Time Table &nbsp;</span>
        <span className={title({ color: "pink" })}>Management&nbsp;</span>
        <br />

        <div className={subtitle({ class: "mt-4" })}>
          Beautiful, fast and modern React UI library.
        </div>
      </div>

      <div className="flex gap-3 mt-8">
        <Link
          href="/start"
        >
          <Button
            className="bg-gradient-to-tr from-pink-500 to-yellow-500 text-white shadow-lg px-6 py-3 text-xl h-12"
            radius="full"
          >
            Get Started
            <span className="transform transition-transform duration-300 group-hover:translate-x-1">
              {"->"}
            </span>
          </Button>
        </Link>
      </div>
    </section>
  );
}
